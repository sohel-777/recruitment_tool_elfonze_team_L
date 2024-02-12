import React from 'react';
import { BrowserRouter , Routes, Route } from 'react-router-dom';
import RegistrationForm from './components/RegistrationForm/RegistrationForm'; 
import LoginForm from './components/Login/LoginForm';
import Home from './components/Home/Home';
import Navbar from './components/Navbar/Navbar';
import "./App.css"
const App = () => {
  return (
    <BrowserRouter>
      
      <Navbar/>
        <Routes>
          
          <Route path="/" exact element={<Home/>} />
          <Route path="/register" element={<RegistrationForm/>} />
          <Route path="/adminregister" element={<RegistrationForm isAdminRegister={true}/>} />
          <Route path="/login" element={<LoginForm/>} />
          {/* <Route path="/dashboard" component={Dashboard} /> */}
          {/* <Route path="/profile" component={UserProfile} /> */}
        </Routes>
     
    </BrowserRouter>
  );
};

export default App;
