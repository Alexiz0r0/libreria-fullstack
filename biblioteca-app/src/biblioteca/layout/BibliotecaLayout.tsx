import { NavBar } from '../components/NavBar';

export const BibliotecaLayout = ({ children }) => {
  return (
    <>
      <NavBar />
      <div>{children}</div>
    </>
  );
};
