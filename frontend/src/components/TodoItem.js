import { useContext, useState } from 'react';
import { TodoDispatchContext } from '../App';

const TodoItem = ({ todo }) => {
  const [isCheck, setCheck] = useState(todo.isCheck);
  const toggleCheck = () => setCheck(!isCheck);

  const { onCheck, onRemove } = useContext(TodoDispatchContext);

  const handleCheck = () => {
    toggleCheck();
    onCheck(todo.id, isCheck);
  };

  return (
    <div className="TodoItem">
      <label className={isCheck ? 'complated' : null} onClick={handleCheck}>
        {todo.content}
      </label>
      <label className="btn_remove" onClick={() => onRemove(todo.id)}>
        ❌
      </label>
    </div>
  );
};

export default TodoItem;
