import { Menubar } from 'primereact/menubar';
import { MenuItem } from 'primereact/menuitem';
import { useNavigate } from 'react-router-dom';
export const NavBar = () => {
  const navigate = useNavigate();

  const items: MenuItem[] = [
    {
      label: 'Autor',
      icon: 'pi pi-fw pi-user',
      command: () => navigate('/biblioteca/autor'),
    },
    {
      label: 'Editorial',
      icon: 'pi pi-fw pi-building',
      command: () => navigate('/biblioteca/editorial'),
    },
    {
      label: 'Libro',
      icon: 'pi pi-fw pi-book',
      command: () => navigate('/biblioteca/libro'),
    },
  ];

  return (
    <div className='card'>
      <Menubar model={items} />
    </div>
  );
};
