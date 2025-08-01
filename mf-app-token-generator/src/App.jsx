// App.js
import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import "./App.css";
import Home from "./assets/Home";

function App() {
  return (
    <Router>
      <Routes>{<Route path="/" element={<Home />} />}</Routes>
    </Router>
  );
}

export default App;
