import './../App.css';

import {BrowserRouter as Link} from 'react-router-dom';

function Nav() {
  return (
    <div className="App">
      <h1>Cat Tracker (logo image here?)</h1>
      <ul className="nav-links">
        <li>Home</li>
        <li>Cat Profiles</li>
        <li>Sightings</li>
        <li>FAQs</li>
        <li>About Us</li>
        <li>Contact Us</li>
        <Link className="btn btn-primary" to="/login">Log In</Link>
        <button className="btn btn-primary">Log Out</button>
      </ul>
    </div>
  );
}

export default Nav;
