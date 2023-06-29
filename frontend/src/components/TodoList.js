import { useContext } from 'react';
import { TodoStateContext } from '../App';

import TodoItem from './TodoItem';

const TodoList = () => {
  const todos = useContext(TodoStateContext);

  return (
    <div className="TodoList">
      <h2>Todo 목록</h2>
      {todos.map((todo) => (
        <TodoItem key={todo.id} todo={todo} />
      ))}
    </div>
  );
};

export default TodoList;
