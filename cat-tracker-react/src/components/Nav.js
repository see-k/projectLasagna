import './../App.css';
import logo from './../cattrackerlogo.png';
import {BrowserRouter as Link} from 'react-router-dom';

function Nav( logout ) {


    return (
        <div className="App">
        <ul className="nav-links">
            <img src={logo} alt="Logo"/>
            <Link className="link" to="/" href="#" >Home</Link>
            <Link to="/cats" href="#">Cat Profiles</Link>
            <Link to="/sightings" href="#">Sightings</Link>
            <Link to="/faq" href="#">FAQs</Link>
            <Link to="/about" href="#">About Us</Link>
            <Link to="/contact" href="#">Contact Us</Link>
            <Link className="btn btn-primary" to="/login">Log In</Link>
            <button className="btn btn-primary" onClick={logout}>Log Out</button>
        </ul>
        </div>
  );
}

export default Nav;
