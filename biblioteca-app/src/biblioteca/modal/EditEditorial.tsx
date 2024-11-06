import { useEffect, useState } from 'react';
import { InputText } from 'primereact/inputtext';
import { Button } from 'primereact/button';
import axios from 'axios';

const initialEditorialInfo = {
  id: '',
  nombre: '',
};

const EditEditorial = (props) => {
  const [editorialInfo, setEditorialInfo] = useState(initialEditorialInfo);

  useEffect(() => {
    setEditorialInfo({ ...editorialInfo, id: props.id });
    fetchEditorialData();
  }, []);

  const fetchEditorialData = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/v1/editoriales/' + props.id);
      if (response) {
        console.log(response);
        setEditorialInfo(response.data);
      }
      return;
    } catch (e) {
      console.log(e);
    }
  };

  const editExistEditorial = async () => {
    try {
      const response = await axios.put(
        'http://localhost:8080/api/v1/editoriales',
        editorialInfo
      );
      if (response) {
        props.setEditorialEdited();
      }
    } catch (e) {
      console.log(e);
    }
  };

  return (
    <>
      <div className='my-4'>
        <span className='p-float-label'>
          <InputText
            id='nombre'
            value={editorialInfo.nombre}
            onChange={(e) => setEditorialInfo({ ...editorialInfo, nombre: e.target.value })}
            className='w-12'
          />
          <label htmlFor='nombre'>nombre</label>
        </span>
      </div>
      <Button label='Edit Libro' severity='info' onClick={() => editExistEditorial()} />
    </>
  );
};

export default EditEditorial;
