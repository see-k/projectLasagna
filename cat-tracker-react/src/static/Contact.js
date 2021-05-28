import './../App.css';
import { Link } from 'react-router-dom';

function Contact() {
  return (
    <div className="App">
      <div className="container-flex mt-5 ">
        <div className="row justify-content-md-center">
          <div className="col">
            <div className="card text-center">
              <h2 className="card-header">Questions? Contact Us!</h2>
              <div className="card-body text-wrap" style={{fontSize: 18}}>
                  <ul>Please contact a member of our team with any questions, comments, or concerns.</ul>
                  <h5>Team Lasagna</h5>
                  <li>Chike Okonta - cokonta@dev-10.com</li>
                  <li>Derrick Fidelman - dfidelman@dev-10.com</li>
                  <li>Quinn Chu - qchu@dev-10.com</li>
                  <ul>Some questions may have already been answered. Check out some <Link to="/faq"> frequently asked questions</Link>.</ul>
                </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Contact;
