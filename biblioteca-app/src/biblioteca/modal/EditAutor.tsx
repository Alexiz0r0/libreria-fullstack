import { useEffect, useState } from 'react';
import { InputText } from 'primereact/inputtext';
import { Button } from 'primereact/button';
import axios from 'axios';

const initialAutorInfo = {
  id: '',
  nombre: '',
};

const EditAutor = (props) => {
  const [autorInfo, setAutorInfo] = useState(initialAutorInfo);

  useEffect(() => {
    setAutorInfo({ ...autorInfo, id: props.id });
    fetchAutorData();
  }, []);

  const fetchAutorData = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/v1/autores/' + props.id);
      if (response) {
        console.log(response);
        setAutorInfo(response.data);
      }
      return;
    } catch (e) {
      console.log(e);
    }
  };

  const editExistAutor = async () => {
    try {
      const response = await axios.put('http://localhost:8080/api/v1/autores', autorInfo);
      if (response) {
        props.setAutorEdited();
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
          <label htmlFor='nombre'>nombre</label>
        </span>
      </div>
      <Button label='Edit Libro' severity='info' onClick={() => editExistAutor()} />
    </>
  );
};

export default EditAutor;
