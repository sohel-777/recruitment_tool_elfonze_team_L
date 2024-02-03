import React from 'react';
import { BrowserRouter , Routes, Route } from 'react-router-dom';
import RegistrationForm from './components/RegistrationForm/RegistrationForm'; 

const App = () => {
  return (
    <BrowserRouter>
      
       
        <Routes>
          {/* <Route path="/" exact component={HomePage} /> */}
          <Route path="/register" element={<RegistrationForm/>} />
         
          {/* <Route path="/dashboard" component={Dashboard} /> */}
          {/* <Route path="/profile" component={UserProfile} /> */}
        </Routes>
     
    </BrowserRouter>
  );
};

export default App;
