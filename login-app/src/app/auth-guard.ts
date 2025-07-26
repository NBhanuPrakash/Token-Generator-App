// import { inject } from '@angular/core';
// import { CanActivateFn, Router } from '@angular/router';

// function isTokenExpired(token: string): boolean {
//   try {
//     const [, payloadBase64] = token.split('.');
//     const payload = JSON.parse(atob(payloadBase64));
//     const exp = payload.exp;

//     if (!exp) return true;

//     const now = Math.floor(Date.now() / 1000); // current time in seconds
//     return exp < now; // token is expired
//   } catch (e) {
//     return true; // any error = treat as expired
//   }
// }

// export const authGuard: CanActivateFn = () => {
//   const router = inject(Router);
//   const token = localStorage.getItem('authToken');

//   console.log('🛡️ AuthGuard executed. Token:', token);

//   if (token && !isTokenExpired(token)) {
//     console.log('✅ Token is valid, allowing access');
//     return true;
//   }

//   console.warn('❌ Invalid or expired token - redirecting to login.');
//   localStorage.clear();
//   router.navigate(['/login'], { queryParams: { reason: 'expired' } });
//   return false;
// };

