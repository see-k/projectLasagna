import './../App.css';
import { useEffect, useState } from 'react';
import { Link, useHistory, useParams } from 'react-router-dom';

function UpdateCat() {

  const defaultCat = {
    catId: 0,
    catName: "N/A",
    imgPath: null,
    catDescription: "N/A",
    disabled: false,
    usersId: 0
  }

  const [cat, setCat] = useState();

  const { id } = useParams();
  const history = useHistory();

  useEffect(() => {
    fetch(`http://localhost:8080/api/cat/${id}`)
    .then(response => response.json())
    .then(data => setAgent(data))
    .catch(error => console.log(error));
  }, [id]);

  const handleUpdate = (event) => {
    // event.preventDefault();

    const newCat = {
      catId: cat.catId,
      catName: catName,
      imgPath: imgPath,
      catDescription: catDescription,
      disabled: false,
      usersId: users.usersId,
    }

  const init = {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
      "Accept": "application/json"
    },
    body: JSON.stringify(newCat)
  };

  
  fetch(`http://localhost:8080/api/cat/${cat.catId}`, init)
    .then(response => {
      if (response.status !== 204) {
        return Promise.reject("could not update");
      }
    })
    .then(history.push('/'))
    .catch(console.log)
  }

  const handleCatNameChange = (event) => {
    setCatName(event.target.value);
  }

  const handleImgPathChange = (event) => {
    setImgPath(event.target.value);
  }

  const handleCatDescChange = (event) => {
    setCatDesc(event.target.value);
  }

  const handleDisabledChange = (event) => {
    setDisabled(event.target.value);
  }

  const handleUsersIdChange = (event) => {
    setUsersId(event.target.value);
  }


  return (
    <div className="App">
      <h1>Edit Cat Profile (admin only)</h1>
    </div>
  );
}

export default UpdateCat;
