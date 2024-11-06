import { useState, useEffect } from 'react';
import { BibliotecaLayout } from '../layout/BibliotecaLayout';
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';
import { Button } from 'primereact/button';
import { Dialog } from 'primereact/dialog';
import axios from 'axios';
import { ConfirmDialog, confirmDialog } from 'primereact/confirmdialog';
import AddEditorial from '../modal/AddEditorial';
import EditEditorial from '../modal/EditEditorial';

interface Editorial {
  id: string;
  nombre: string;
}

export const EditorialPage = () => {
  const [editorial, setEditorial] = useState<Editorial[]>([
    {
      id: 'def',
      nombre: 'paper',
    },
  ]);

  const [showAddMode, setShowAddMode] = useState(false);
  const [showEditMode, setShowEditMode] = useState(false);
  const [selectedEditorialId, setSelectedEditorialId] = useState(null);

  useEffect(() => {
    getAllEditorial();
  }, []);

  const getAllEditorial = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/v1/editoriales');
      const { data } = response;
      console.log(data);
      if (response) {
        setEditorial(data);
      }
    } catch (e) {
      console.log(e);
    }
  };

  const deleteEditorialConfirm = (editorial) => {
    console.log(editorial);

    confirmDialog({
      message: 'Are you sure you want to delete this editorial?',
      header: 'Confirmation',
      icon: 'pi pi-trash',
      accept: () => {
        deleteUser(editorial);
      },
    });
  };

  const deleteUser = async (editorial) => {
    try {
      const response = await axios.delete('http://localhost:8080/api/v1/editoriales', {
        data: editorial,
      });
      if (response) {
        getAllEditorial();
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
            setSelectedEditorialId(rowDate.id);
            setShowEditMode(true);
          }}
        />
        <Button
          icon='pi pi-trash'
          rounded
          severity='danger'
          aria-label='User'
          size='small'
          onClick={() => deleteEditorialConfirm(rowDate)}
        />
      </div>
    );
  };

  return (
    <>
      <BibliotecaLayout>
        <div className='flex justify-content-between flex-wrap'>
          <div className='flex align-items-center justify-content-center w-4rem h-4rem font-bold border-round m-2'>
            Editorial
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
          <DataTable value={editorial} tableStyle={{ minWidth: '50rem' }}>
            <Column field='id' header='Code'></Column>
            <Column field='nombre' header='Name'></Column>
            <Column header='Actions' body={actionsTemplate}></Column>
          </DataTable>
        </div>
      </BibliotecaLayout>
      <Dialog
        header='Add New editorial'
        visible={showAddMode}
        style={{ width: '30vw' }}
        onHide={() => setShowAddMode(false)}
      >
        <AddEditorial
          setEditorialAdded={() => {
            setShowAddMode(false);
            getAllEditorial();
          }}
        />
      </Dialog>
      <Dialog
        header='Edit Exist editorial'
        visible={showEditMode}
        style={{ width: '30vw' }}
        onHide={() => setShowEditMode(false)}
      >
        <EditEditorial
          id={selectedEditorialId}
          setEditorialEdited={() => {
            setShowEditMode(false);
            getAllEditorial();
          }}
        />
      </Dialog>
      <ConfirmDialog />
    </>
  );
};
