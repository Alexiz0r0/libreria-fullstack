import { useEffect, useState } from 'react';
import { InputText } from 'primereact/inputtext';
import { Button } from 'primereact/button';
import axios from 'axios';

const initialAutorInfo = {
  nombre: '',
};

const AddAutor = (props) => {
  const [autorInfo, setAutorInfo] = useState(initialAutorInfo);

  useEffect(() => {}, []);

  const addNewAutor = async () => {
    try {
      const response = await axios.post('http://localhost:8080/api/v1/autores', autorInfo);
      if (response) {
        props.setAutorAdded();
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
            value={autorInfo.nombre}
            onChange={(e) => setAutorInfo({ ...autorInfo, nombre: e.target.value })}
            className='w-12'
          />
          <label htmlFor='name'>name</label>
        </span>
      </div>
      <Button label='Add New autor' severity='info' onClick={() => addNewAutor()} />
    </>
  );
};

export default AddAutor;
