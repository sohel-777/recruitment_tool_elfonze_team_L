import React from 'react';
import { BrowserRouter , Routes, Route } from 'react-router-dom';
import RegistrationForm from './components/RegistrationForm/RegistrationForm'; 
import LoginForm from './components/Login/LoginForm';

const App = () => {
  return (
    <BrowserRouter>
      
       
        <Routes>
          {/* <Route path="/" exact component={HomePage} /> */}
          <Route path="/register" element={<RegistrationForm/>} />
          <Route path="/login" element={<LoginForm/>} />
          {/* <Route path="/dashboard" component={Dashboard} /> */}
          {/* <Route path="/profile" component={UserProfile} /> */}
        </Routes>
     
    </BrowserRouter>
  );
};

export default App;
