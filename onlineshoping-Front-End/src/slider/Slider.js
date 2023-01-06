import React from 'react'
import { Container, } from 'react-bootstrap';
import Carousel from 'react-bootstrap/Carousel';
import resim1 from "../images/slider/resim1.jpg";
import resim2 from "../images/slider/resim2.png";
import resim3 from "../images/slider/resim3.png";
import "./Slider.css";
const Slider = () => {
  return (
   <div>
   
  <Container className='containersl mt-5 ' >
<Carousel className='img1 d-flex justify-align-center' >

      <Carousel.Item className=''>
        <img
          className=" justify-content-center"
          src={resim1}
          alt="First slide"
           width={"100%"}
          height={"500px"}
        />
        <Carousel.Caption>
          <h3>yazilar</h3>
          <p></p>
        </Carousel.Caption>
      </Carousel.Item>
    
      <Carousel.Item>
        <img
          className=""
          src={resim2}
          alt="Second slide"
       width={"100%"}
          height={"500px"}
        />

        <Carousel.Caption>
          <h3></h3>
          <p></p>
        </Carousel.Caption>
      </Carousel.Item>
      <Carousel.Item >
        <img
          className=" "
          src={resim3}
          alt="Third slide"
          width={"100%"}
          height={"500px"}
        />

        <Carousel.Caption>
          <h3></h3>
          <p>
           
          </p>
        </Carousel.Caption>
      </Carousel.Item>
    </Carousel>
   </Container>
   </div>
 
    
  )
}

export default Slider