import { useContext, useRef, useState } from 'react';
import { TodoDispatchContext } from '../App';

const TodoCreate = () => {
  const [content, setContent] = useState('');
  const { onCreate } = useContext(TodoDispatchContext);

  const input = useRef();

  const handleSubmit = (e) => {
    e.preventDefault();

    if (content === '') {
      input.current.focus();
      return;
    }
    onCreate(content);
    setContent('');
  };

  return (
    <div className="TodoCreate">
      <h2>Todo 작성</h2>
      <form onSubmit={handleSubmit}>
        <input ref={input} value={content} onChange={(e) => setContent(e.target.value)} />
        <button type="submit">작성</button>
      </form>
    </div>
  );
};

export default TodoCreate;
