import React from 'react';
import {BrowserRouter as Router, Switch, Route} from "react-router-dom";
import About from './about/About';
import './App.css';
import Footer from './footer/Footer';
import Header from './header/Header';
import Register from "./register/Register"
import Home from './home/Home';
import Slider from './slider/Slider';
import Login from './login/Login';

function App() {
  return (
    <div className="App">
    <Router>
      <Header /> 
       
        <Switch>
            <Route  exact path="/" element={<Slider  />}/>    
            <Route  path="/home" element={<Home  />}/> 
             <Route path="/about" element={<About  />}/>
              <Route path="/login" element={ <Login />}/>
              <Route path="/register" element={ <Register />}/>
        </Switch>
       
      <Footer />
    </Router> 
    </div>
  );
}

export default App;
