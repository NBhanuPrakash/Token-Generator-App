import React, { useState } from "react";
import axios from "axios";
import "./Home.css"; // Ensure you create this file for custom styles
import { FaCheck } from "react-icons/fa";
import { FaEye, FaEyeSlash } from "react-icons/fa";

const Home = () => {
  const [activeTab, setActiveTab] = useState("signin");
  const [token, setToken] = useState(""); // For displaying the token
  const [formData, setFormData] = useState({
    email: "",
    password: "",
    role: "",
  });
  const [errorMessage, setErrorMessage] = useState("");
  const [successMessage, setSuccessMessage] = useState("");
  const [isCopied, setIsCopied] = useState(false); // State for copy status
  const [showPassword, setShowPassword] = useState(false); // State to toggle password visibility

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const resetFormData = () => {
    setFormData({
      email: "",
      password: "",
      role: "",
    });
  };

  const handleSignIn = async () => {
    try {
      const response = await axios.post("http://localhost:8080/login", {
        userName: formData.email,
        password: formData.password,
      });
      setToken(response.data); // Assuming the token is returned in response.data
      setErrorMessage(""); // Clear error message
      resetFormData(); // Reset form data after successful login
    } catch (error) {
      setErrorMessage("Unauthorized token generator.");
      console.error("Error logging in:", error.response?.data || error.message);
      setTimeout(() => setErrorMessage(""), 3000); // Clear error after 3 seconds
    }
  };

  const handleSignUp = async () => {
    try {
      await axios.post("http://localhost:8080/register", {
        userName: formData.email,
        password: formData.password,
        roles: formData.role,
      });
      setSuccessMessage("User registered successfully!");
      setErrorMessage(""); // Clear error message
      resetFormData(); // Reset form data after successful signup
      setTimeout(() => setSuccessMessage(""), 3000); // Clear success message after 3 seconds
    } catch (error) {
      setErrorMessage(
        "Error signing up: " + (error.response?.data || error.message)
      );
      console.error("Error signing up:", error.response?.data || error.message);
      setTimeout(() => setErrorMessage(""), 3000); // Clear error after 3 seconds
    }
  };

  const copyToClipboard = () => {
    if (token) {
      navigator.clipboard.writeText(token);
      setIsCopied(true);
      setTimeout(() => setIsCopied(false), 2000); // Reset copy status after 2 seconds
    }
  };

  const togglePasswordVisibility = () => {
    setShowPassword((prevState) => !prevState);
  };

  return (
    <div className="main-container">
      <div className="left-side">
        <div className="header">
          <div
            className={activeTab === "signin" ? "active" : ""}
            onClick={() => setActiveTab("signin")}
          >
            Sign In
          </div>
          <div
            className={activeTab === "signup" ? "active" : ""}
            onClick={() => setActiveTab("signup")}
          >
            Sign Up
          </div>
        </div>
        {activeTab === "signin" && (
          <div className="form">
            <h2>Sign In</h2>
            {errorMessage && <p className="error-message">{errorMessage}</p>}
            <input
              type="email"
              name="email"
              placeholder="Email"
              value={formData.email}
              onChange={handleChange}
              required
            />
            <div className="password-container">
              <input
                type={showPassword ? "text" : "password"}
                name="password"
                placeholder="Password"
                value={formData.password}
                onChange={handleChange}
                required
              />
              <span onClick={togglePasswordVisibility} className="toggle-eye">
                {showPassword ? <FaEyeSlash /> : <FaEye />}
              </span>
            </div>
            <button onClick={handleSignIn}>Generate Token</button>
          </div>
        )}
        {activeTab === "signup" && (
          <div className="form">
            <h2>Sign Up</h2>
            {successMessage && (
              <p className="success-message">{successMessage}</p>
            )}
            {errorMessage && <p className="error-message">{errorMessage}</p>}
            <input
              type="email"
              name="email"
              placeholder="Email"
              value={formData.email}
              onChange={handleChange}
              required
            />
            <div className="password-container">
              <input
                type={showPassword ? "text" : "password"}
                name="password"
                placeholder="Password"
                value={formData.password}
                onChange={handleChange}
                required
              />
              <span onClick={togglePasswordVisibility} className="toggle-eye">
                {showPassword ? <FaEyeSlash /> : <FaEye />}
              </span>
            </div>
            <select
              name="role"
              value={formData.role}
              onChange={handleChange}
              required
            >
              <option value="" disabled>
                Roles
              </option>
              <option value="ROLE_ADMIN">Admin</option>
              <option value="ROLE_USER">User</option>
              <option value="ROLE_GUEST">Guest</option>
            </select>
            <button onClick={handleSignUp}>Sign Up</button>
          </div>
        )}
      </div>
      <div className="right-side">
        <h2>Token Generator</h2>
        <textarea
          readOnly
          placeholder="Your token will appear here."
          value={token}
          style={{ color: "white" }}
        />
        <div className="copy-container">
          <button onClick={copyToClipboard}>Copy Token</button>
          {isCopied && (
            <FaCheck className="copy-success-icon" style={{ color: "green" }} />
          )}
        </div>
      </div>
    </div>
  );
};

export default Home;
