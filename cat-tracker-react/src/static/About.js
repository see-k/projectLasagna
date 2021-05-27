import './../App.css';
import { Link } from 'react-router-dom';

function About() {
  return (
    <div className="App">
      <div className="container-flex mt-5 ">
        <div className="row justify-content-md-center">
          <div className="col">
            <div className="card text-center">
              <h2 className="card-header">About</h2>
                <div className="card-body text-wrap">
                  <ul>This is Cat Tracker!</ul>
                  <ul>An application designed to let cat lovers from all over explore and document their encounters with cats they find around the world</ul>
                  <ul>This app was created by Team Lasagna.</ul>
                  <ul>To contact a member of the team, please visit the <Link to="/contact">Contact Us</Link> with any questions.</ul>
                </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default About;
