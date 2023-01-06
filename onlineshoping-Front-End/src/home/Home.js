import React from 'react'
import {Container, Row, Col} from 'react-bootstrap';
import "./Home.css";
const Home = () => {
  return (
    <div className="div m-5">
     <Container>
<Row className='d-flex'>
  <Col className="left-col ">
    left Col
  </Col>
  <Col>
  Right Col
  </Col>
</Row>
     </Container>
    </div>
  )
}

export default Home