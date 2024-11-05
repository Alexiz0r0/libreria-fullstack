import { Navigate, Route, Routes } from 'react-router-dom';
import { AutorPage } from '../pages/AutorPage';
import { EditorialPage } from '../pages/EditorialPage';
import { LibroPage } from '../pages/LibroPage';

export const BibliotecaRoutes = () => {
  return (
    <Routes>
      <Route path='autor' element={<AutorPage />} />
      <Route path='editorial' element={<EditorialPage />} />
      <Route path='libro' element={<LibroPage />} />
      <Route path='/*' element={<Navigate to='/biblioteca/libro' />} />
    </Routes>
  );
};
