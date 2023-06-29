import React, { useEffect, useState } from 'react';
import axios from 'axios';

import './App.css';

import Header from './components/Header';
import TodoCreate from './components/TodoCreate';
import TodoList from './components/TodoList';

export const TodoStateContext = React.createContext();
export const TodoDispatchContext = React.createContext();

function App() {
  const baseUrl = 'http://localhost:8080';

  const [todos, setTodos] = useState([]);

  const getTodos = async () => {
    await axios
      .get(baseUrl + '/api/todos')
      .then((response) => setTodos(response.data.todos))
      .catch((error) => console.log(error));
  };

  useEffect(() => {
    getTodos();
  }, []);

  const onCreate = async (content) => {
    await axios
      .post(baseUrl + '/api/todos', {
        content,
      })
      .then((response) => getTodos())
      .catch((error) => console.log(error));
  };

  const onCheck = async (targetId, isCheck) => {
    await axios
      .patch(baseUrl + `/api/todos/${targetId}`, {
        isCheck,
      })
      .catch((error) => console.log(error));
  };

  const onRemove = async (targetId) => {
    await axios
      .delete(baseUrl + `/api/todos/${targetId}`)
      .then((response) => getTodos())
      .catch((error) => console.log(error));
  };

  return (
    <TodoStateContext.Provider value={todos}>
      <TodoDispatchContext.Provider value={{ onCreate, onCheck, onRemove }}>
        <div className="App">
          <Header />
          <TodoCreate />
          <TodoList />
        </div>
      </TodoDispatchContext.Provider>
    </TodoStateContext.Provider>
  );
}

export default App;
