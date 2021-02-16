'use strict';

const todoURL = "http://localhost:8080/todo";
const todoSystemURL = "http://localhost:8080/todoSystem";

// const todoReadId = document.querySelector("#todoReadId");

const TodoIdRead = document.querySelector("#todoIdRead");

const todoTitle = document.querySelector('#createTitle');
const todoDescription = document.querySelector('#createDescription');
const todoDate = document.querySelector('#createDate');
const todoDone = document.querySelector('#createDone');

const result = document.querySelector("#result"); 

const todoIdUpdate = document.querySelector('#todoIdUpdate');
const todoTitleUpdate = document.querySelector('#todoTitleUpdate');
const todoDescriptionUpdate = document.querySelector('#todoDescriptionUpdate');
const todoDateUpdate = document.querySelector('#todoDateUpdate');
const todoDoneUpdate = document.querySelector('#updateDone');

// const todoDeleteId = document.querySelector('#deleteTodo');

const TodoIdDelete = document.querySelector("#deleteTodoId");


//CRUD FUNCTIONALITY => CREATE, READ, UPDATE, DELETE
//API => POST, GET, PUT, DELETE


//DOM: 

//POST = CREATE:


const printValue = (newResult) => {
    result.value = newResult; 
}

const addToHistory = (result, readAll) => {
    const p = document.createElement("p");
    const info = document.createTextNode(`${readAll} = ${result}`);
    p.appendChild(info);
    history.appendChild(p);
}


const createTodo = () => {

    const todoTitleValue = todoTitle.value;
    const todoDescriptionValue = todoDescription.value;
    const todoDateValue = todoDate.value;
    const todoDoneValue = todoDone.value;

    let data = {

        "title": todoTitleValue,
        "description": todoDescriptionValue,
        "date": todoDateValue,
        "finish": todoDoneValue
    }

    fetch("http://localhost:8080/todo/create", {
        method: "POST",
        body: JSON.stringify(data),
        headers: {
            "Content-Type": "application/json"
        }
    })
        .then(response => response.json())
        .then(info => console.log(info))
        .catch(err => console.error(`Something went wrong! ${err}`));

}


//GET = READ:

const readTodoId = () => {

    const todoIdRead = TodoIdRead.value;
    // const todoReadId = todoReadId.value;

    fetch(`http://localhost:8080/todo/read/${todoIdRead}`)

        .then((response) => {
            if (response.status !== 200) {
                console.log(`Looks Like there was a problem.Status Code: ${response.status}`);
                return;
            }
            response.json().then((infofromserver) => console.log(infofromserver));
        })
        .catch((err) => console.log(`Fetch Error: -S ${err}`)
        )

}

//GET = READ ALL:

const readAllTodo = () => {

    // printValue(newResult);

    fetch('http://localhost:8080/todo/readAll')
        .then(response => response.json())
        .then(info => {
            for (let band of info) {
                console.log(band);
            }
        })
        .catch(err => console.error(`error ${err}`))
}

//PUT = UPDATE:
const updateTodo = () => {

        const todo_IdValue = todoIdUpdate.value;
        const todo_TitleValue = todoTitleUpdate.value;
        const todo_DescriptionValue = todoDescriptionUpdate.value;
        const todo_DateValue = todoDateUpdate.value;
        const todo_DoneValue = todoDoneUpdate.value;

    let data = {

        "id": todo_IdValue,
        "title": todo_TitleValue,
        "description": todo_DescriptionValue,
        "date": todo_DateValue,
        "finish": todo_DoneValue
    }

    fetch(`http://localhost:8080/todo/update/${todo_IdValue}`, {
        method: "PUT",
        body: JSON.stringify(data),
        headers: {
            "Content-Type": "applocation/json"
        }
    })
        .then(response => response.json())
        .then(info => console.log(info))
        .catch(err => console.error(`Something Went Wrong! ${err}`));
}


//DELETE/REMOVE = DELETE: 
const deleteTodo = () => {

    // const todoDeleteId = todoIdDelete.value;

    const todoIdDelete = TodoIdDelete.value;

    fetch(`http://localhost:8080/todo/delete/${todoIdDelete}`, {
        method: "DELETE",
        headers: {
            "Content-Type": "application/json"
        }
    })
        .then(response => response.json())
        .then((info) => console.log(info))
        // .then(info => console.log(info))
        .catch(err => console.error(`Something Went Wrong!! ${err}`))

}