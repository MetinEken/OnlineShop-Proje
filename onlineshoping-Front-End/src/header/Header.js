import React from 'react'
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';
import {Form, Button} from "react-bootstrap"
import { BsFillPersonFill } from "react-icons/bs";
import {FaRegistered} from "react-icons/fa";
import {FaShoppingCart} from "react-icons/fa";
import "./Header.css";
import logo1 from "../images/logo/logo1.png"
const Header = () => {
  return (
    <div>      
      <Navbar bg="light" expand="lg">
      <Container>
     
         <Navbar.Brand href="/">  <img src={logo1} alt="logo" width={"80px"}/>    
          Online Shoping</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            <Nav.Link href="/home">Home</Nav.Link>
            <Nav.Link href="/link">Link</Nav.Link>
            <NavDropdown title="Products" id="basic-nav-dropdown">
              <NavDropdown.Item href="/phones">Phone</NavDropdown.Item>
              <NavDropdown.Item href="/laptops">
                Laptops
              </NavDropdown.Item>
              <NavDropdown.Item href="headphones">Headphones</NavDropdown.Item>
              <NavDropdown.Divider />
              <NavDropdown.Item href="products">
                Another Products
              </NavDropdown.Item>              
            </NavDropdown>
                    
          </Nav>
           
        </Navbar.Collapse>
        <Container > 
          <Form className=" d-flex justify-content-center ">
            <Form.Control
              type="search"
              placeholder="Search"
              className="me-2"
              aria-label="Search"
            />
            <Button variant="outline-success">Search</Button>
          </Form> </Container>
          
      </Container>
          
      <div className='d-flex justify-content-end '>
        <Nav.Link className='btn me-3 ms-3' href="/cart">
              <div className='sign-p'>< FaShoppingCart/>
              <p   >Cart</p>
                </div>  
                </Nav.Link>
            <Nav.Link className='btn me-3 ms-3' href="/login">
              <div className='sign-p'><BsFillPersonFill/>
              <p   >Sign in</p>
                </div>  
                </Nav.Link>
            <Nav.Link className='btn me-5 ' href="/register">
              <div className='sign-p'><FaRegistered/>Register</div>
              
              
              </Nav.Link>
             </div>
    </Navbar></div>
  )
}

export default Header