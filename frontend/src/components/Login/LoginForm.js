import React, { useState } from "react";
import { Link, Router } from "react-router-dom";
import "./styles.css";
import Home from "../Home/Home";

const LoginForm = () => {

  const [formData, setFormData] = useState({
    username: "",
    email: "",
    organizationName: "",
    password: "",
  });

  const [errors, setErrors] = useState({});

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const validateForm = () => {
    let valid = true;
    const newErrors = {};

    // Validate username
    if (!formData.username.trim()) {
      newErrors.username = "Username is required";
      valid = false;
    }

    // Validate email
    if (
      !formData.email.trim() ||
      !(formData.email.includes("@") && formData.email.includes("."))
    ) {
      newErrors.email = "Valid email is required";
      valid = false;
    }

    // Validate organization name
    if (!formData.organizationName.trim()) {
      newErrors.organizationName = "Organization name is required";
      valid = false;
    }

    // Validate password
    if (formData.password.length < 6) {
      newErrors.password = "Password must be at least 6 characters";
      valid = false;
    }

    setErrors(newErrors);
    return valid;
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (validateForm()) {
      try {
        const response = await fetch(process.env.REACT_APP_REGISTER_URL, {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(formData),
        });

        if (response.ok) {
          console.log("Registration successful");
          Router.push('/')
        } else {
          console.error("Registration failed");
        }
      } catch (error) {
        console.error("Error during registration:", error);
      }
    }
  };

  return (
    <form onSubmit={handleSubmit}>
    <h1>Login</h1>
    {/* <div>
      <label htmlFor="username">Username:</label>
      <input
        type="text"
        id="username"
        name="username"
        placeholder="Enter your username"
        value={formData.username}
        onChange={handleChange}
      />
      <span className="error">{errors.username}</span>
    </div> */}

    <div>
      <label htmlFor="email">Email:</label>
      <input
        type="email"
        id="email"
        name="email"
        placeholder="Enter your email"
        value={formData.email}
        onChange={handleChange}
      />
      <span className="error">{errors.email}</span>
    </div>

    {/* <div>
      <label htmlFor="organizationName">Organization Name:</label>
      <input
        type="text"
        id="organizationName"
        name="organizationName"
        placeholder="Enter your organization name"
        value={formData.organizationName}
        onChange={handleChange}
      />
      <span className="error">{errors.organizationName}</span>
    </div> */}

    <div>
      <label htmlFor="password">Password:</label>
      <input
        type="password"
        id="password"
        name="password"
        placeholder="Enter your password"
        value={formData.password}
        onChange={handleChange}
      />
      <span className="error">{errors.password}</span>
    </div>

    <button type="submit">Login</button>
    <p>
     Don't have an account? <Link to="/register">Register here</Link>
    </p>
  </form>
);
};


export default LoginForm
