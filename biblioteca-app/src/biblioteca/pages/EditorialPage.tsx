import { useState, useEffect } from 'react';
import { BibliotecaLayout } from '../layout/BibliotecaLayout';
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';
import { Button } from 'primereact/button';

interface Editorial {
  id: string;
  name: string;
}

export const EditorialPage = () => {
  const [editorial, setEditorial] = useState<Editorial[]>([
    {
      id: 'def',
      name: 'paper',
    },
  ]);

  const actionsTemplate = (rowDate) => {
    return (
      <div className='flex flex-wrap justify-content-center gap-3'>
        <Button
          icon='pi pi-file-edit'
          rounded
          severity='secondary'
          aria-label='User'
          size='small'
        />
        <Button icon='pi pi-trash' rounded severity='danger' aria-label='User' size='small' />
      </div>
    );
  };

  return (
    <BibliotecaLayout>
      <div className='flex justify-content-between flex-wrap'>
        <div className='flex align-items-center justify-content-center w-4rem h-4rem font-bold border-round m-2'>
          Editorial
        </div>
        <div className='flex align-items-center justify-content-center w-4rem h-4rem font-bold border-round m-2'>
          <Button icon='pi pi-plus' rounded severity='info' aria-label='User' />
        </div>
      </div>
      <div className='card'>
        <DataTable value={editorial} tableStyle={{ minWidth: '50rem' }}>
          <Column field='id' header='Code'></Column>
          <Column field='name' header='Name'></Column>
          <Column header='Actions' body={actionsTemplate}></Column>
        </DataTable>
      </div>
    </BibliotecaLayout>
  );
};
