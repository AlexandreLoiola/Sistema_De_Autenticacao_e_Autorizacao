import React from "react";
import { createBrowserRouter } from "react-router-dom";
import App from "../App";
import ErrorPage from "../Pages/ErrorPage/ErrorPage";
import Home from "../Pages/Home/Home";
import Login from "../Pages/Login/Login";
import RecoverPass from "../Pages/RecoverPass/RecoverPass";
import AlterPassword from "../Pages/RecoverPass/AlterPassword";

const router = createBrowserRouter([
  {
    path: "/",
    element: <App />,
    errorElement: <ErrorPage />,
    children: [
      {
        path: "/",
        element: <Home />,
      },
      {
        path: "/login",
        element: <Login />,
      },
      {
        path: "/forgot-password",
        element: <RecoverPass />,
      },
      {
        path: "/alter-password",
        element: <AlterPassword />,
      },
    ],
  },
]);

export default router;
