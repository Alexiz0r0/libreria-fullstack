import { useState, useEffect } from 'react';
import { BibliotecaLayout } from '../layout/BibliotecaLayout';
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';
import { Button } from 'primereact/button';
import { Dialog } from 'primereact/dialog';
import AddAutor from '../modal/AddAutor';
import EditAutor from '../modal/EditAutor';
import axios from 'axios';
import { ConfirmDialog, confirmDialog } from 'primereact/confirmdialog';

interface Autor {
  id: string;
  nombre: string;
}

export const AutorPage = () => {
  const [autor, setAutor] = useState<Autor[]>([
    {
      id: 'abc',
      nombre: 'ryan',
    },
  ]);

  const [showAddMode, setShowAddMode] = useState(false);
  const [showEditMode, setShowEditMode] = useState(false);
  const [selectedAutorId, setSelectedAutorId] = useState(null);

  useEffect(() => {
    getAllAutor();
  }, []);

  const getAllAutor = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/v1/autores');
      const { data } = response;
      console.log(data);
      if (response) {
        setAutor(data);
      }
    } catch (e) {
      console.log(e);
    }
  };

  const deleteUserConfirm = (autor) => {
    console.log(autor);

    confirmDialog({
      message: 'Are you sure you want to delete this autor?',
      header: 'Confirmation',
      icon: 'pi pi-trash',
      accept: () => {
        deleteUser(autor);
      },
    });
  };

  const deleteUser = async (autor) => {
    try {
      const response = await axios.delete('http://localhost:8080/api/v1/autores', {
        data: autor,
      });
      if (response) {
        getAllAutor();
      }
    } catch (e) {
      console.log(e);
    }
  };

  const actionsTemplate = (rowDate) => {
    return (
      <div className='flex flex-wrap justify-content-center gap-3'>
        <Button
          icon='pi pi-file-edit'
          rounded
          severity='secondary'
          aria-label='User'
          size='small'
          onClick={() => {
            setSelectedAutorId(rowDate.id);
            setShowEditMode(true);
          }}
        />
        <Button
          icon='pi pi-trash'
          rounded
          severity='danger'
          aria-label='User'
          size='small'
          onClick={() => deleteUserConfirm(rowDate)}
        />
      </div>
    );
  };

  return (
    <>
      <BibliotecaLayout>
        <div className='flex justify-content-between flex-wrap'>
          <div className='flex align-items-center justify-content-center w-4rem h-4rem font-bold border-round m-2'>
            Autor
          </div>
          <div className='flex align-items-center justify-content-center w-4rem h-4rem font-bold border-round m-2'>
            <Button
              icon='pi pi-plus'
              rounded
              severity='info'
              aria-label='User'
              onClick={() => setShowAddMode(true)}
            />
          </div>
        </div>

        <div className='card'>
          <DataTable value={autor} tableStyle={{ minWidth: '50rem' }}>
            <Column field='id' header='Code'></Column>
            <Column field='nombre' header='Name'></Column>
            <Column header='Actions' body={actionsTemplate}></Column>
          </DataTable>
        </div>
      </BibliotecaLayout>
      <Dialog
        header='Add New autor'
        visible={showAddMode}
        style={{ width: '30vw' }}
        onHide={() => setShowAddMode(false)}
      >
        <AddAutor
          setAutorAdded={() => {
            setShowAddMode(false);
            getAllAutor();
          }}
        />
      </Dialog>
      <Dialog
        header='Edit Exist Libro'
        visible={showEditMode}
        style={{ width: '30vw' }}
        onHide={() => setShowEditMode(false)}
      >
        <EditAutor
          id={selectedAutorId}
          setUserEdited={() => {
            setShowEditMode(false);
            getAllAutor();
          }}
        />
      </Dialog>
      <ConfirmDialog />
    </>
  );
};
