import './../App.css';
import { Link } from 'react-router-dom';

function FAQ() {
  return (
    <div className="App">
      <div className="container-flex mt-5 ">
        <div className="row justify-content-md-center">
          <div className="col">
            <div className="card text-center">
              <h2 className="card-header">Frequently Asked Questions</h2>
                <div className="card-body">
                  <ul>Here are some questions we have already answered.</ul>
                  <ul>---------------------------</ul>
                  <ul>Q: How do I use the Cat Tracker?</ul>
                  <ul>A: Once you're signed in, you can then navigate to our sightings page where you can</ul>
                  <ul>document your recent cat sighting! </ul>
                  <ul>---------------------------</ul>
                  <ul>Q: Do I have to have an account to post a sighting?</ul>
                  <ul>A: Yes, if you do not already have an account, you can <Link to="/register">  register here</Link></ul>
                  <ul>---------------------------</ul>
                  <ul>Q: I accidentally created a sighting/cat with the wrong data. How do I fix this?</ul>
                  <ul>A: If you wish to fix your sighting/cat to include the right information, or simply delete it, you can reach out to us</ul>
                  <ul>with your request and we will take care of it for you! </ul>
                  <ul>---------------------------</ul>
                  <ul>Don't see an answer to your question? Feel free to <Link to="/contact"> contact a Team Lasagna member</Link> with any questions.</ul>
                </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default FAQ;
