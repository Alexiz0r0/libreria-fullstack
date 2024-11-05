import { Navigate, Route, Routes } from 'react-router-dom';
import { AuthRoutes } from '../auth/routes/AuthRoutes';
import { BibliotecaRoutes } from '../biblioteca/routes/BibliotecaRoutes';

export const AppRouter = () => {
  return (
    <Routes>
      <Route path='/auth/*' element={<AuthRoutes />} />
      <Route path='/biblioteca/*' element={<BibliotecaRoutes />} />
      <Route path='/*' element={<Navigate to='/biblioteca' />} />
    </Routes>
  );
};
