import axios from 'axios';
import { useState } from 'react';

const UploadForm = () => {
  const [title, setTitle] = useState('');
  const [content, setContent] = useState('');
  const [file, setFile] = useState(null);

  const handleSubmit = (e) => {
    e.preventDefault();

    const formData = new FormData();
    formData.append('title', title);
    formData.append('content', content);
    formData.append('file', file);

    axios
      .post('http://localhost:8080/api/todos/upload', formData, {
        headers: {
          'Content-Type': 'multipart/form-data',
        },
      })
      .then((res) => console.log(res));
  };

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <div>
          제목: <input type="text" value={title} onChange={(e) => setTitle(e.target.value)} />
        </div>
        <div>
          내용: <input type="text" value={content} onChange={(e) => setContent(e.target.value)} />
        </div>
        <div>
          <input type="file" onChange={(e) => setFile(e.target.files[0])} />
        </div>
        <button type="submit">전송</button>
      </form>
    </div>
  );
};

export default UploadForm;
