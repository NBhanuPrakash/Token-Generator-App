import { HttpErrorResponse, HttpHandlerFn, HttpInterceptorFn, HttpRequest } from '@angular/common/http';
import { inject } from '@angular/core';
import { Router } from '@angular/router';
import { catchError, throwError } from 'rxjs';

export const authInterceptorInterceptor: HttpInterceptorFn = (
  req: HttpRequest<any>,
  next: HttpHandlerFn
) => {
  const router = inject(Router)
  const token =
    typeof window !== 'undefined' ? localStorage.getItem('authToken') : null;



  if (token && req.url.includes('/user-details')) {
    const cloned = req.clone({
      setHeaders: {
        Authorization: `Bearer ${token}`
      }
    });

    return next(cloned);
  }

  return next(req).pipe(
  catchError((error: HttpErrorResponse) => {
    if (
      (error.status === 401 || error.status === 403) &&
      !req.url.includes('/login')
    ) {
      console.warn('Session expired or unauthorized, redirecting to login...');
      if (typeof window !== 'undefined') {
        localStorage.clear();
      }
      router.navigate(['/login'], { replaceUrl: true });
    }
    return throwError(() => error);
  }));
};
