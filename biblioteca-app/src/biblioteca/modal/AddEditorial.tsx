import { useEffect, useState } from 'react';
import { InputText } from 'primereact/inputtext';
import { Button } from 'primereact/button';
import axios from 'axios';

const initialEditorialInfo = {
  nombre: '',
};

const AddEditorial = (props) => {
  const [editorialInfo, setEditorialInfo] = useState(initialEditorialInfo);

  useEffect(() => {}, []);

  const addNewEditorial = async () => {
    try {
      const response = await axios.post(
        'http://localhost:8080/api/v1/editoriales',
        editorialInfo
      );
      if (response) {
        props.setEditorialAdded();
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
          <label htmlFor='name'>name</label>
        </span>
      </div>
      <Button label='Add New editorial' severity='info' onClick={() => addNewEditorial()} />
    </>
  );
};

export default AddEditorial;
