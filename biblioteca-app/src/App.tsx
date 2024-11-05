import { getEnvironments } from './helpers';
import { AppRouter } from './router/AppRouter.js';

function App() {
  const env = getEnvironments();

  console.log(env);

  return (
    <>
      <AppRouter />
    </>
  );
}

export default App;
