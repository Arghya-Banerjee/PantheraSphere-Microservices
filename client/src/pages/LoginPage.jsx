import Navbar from "../components/NavBar";
import { Link } from "react-router-dom";

function LoginPage() {
  return (
    <>
      <Navbar />
      <main className="flex items-center justify-center min-h-screen bg-gradient-to-br from-blue-500 to-white p-5">
        <div
          className="bg-white rounded-2xl shadow-2xl p-8 max-w-xl w-full text-blue-800 flex flex-col items-center"
          role="main"
          aria-label="PantheraSphere login form"
          style={{ minHeight: "500px", maxWidth: "480px" }}
        >
          <h1
            className="font-oswald text-4xl font-extrabold tracking-widest mb-3 relative select-none text-blue-700"
            aria-label="PantheraSphere logo and title"
          >
            PANTHERASPHERE
            <span
              aria-hidden="true"
              className="absolute inset-x-0 top-1/2 h-1 rounded-md opacity-20"
              style={{
                background:
                  "repeating-linear-gradient(-45deg, transparent, transparent 5px, #60a5fa 6px, white 9px)",
                transform: "translateY(-50%)",
                zIndex: -1,
              }}
            ></span>
          </h1>
          <p className="text-blue-600 text-lg italic font-medium mb-6 text-center">
            Unleash your power. Login below.
          </p>

          <form className="w-full flex flex-col space-y-4" noValidate>
            <div>
              <label
                htmlFor="user"
                className="text-blue-900 font-semibold mb-1 text-base"
              >
                Username or Email
              </label>
              <input
                type="text"
                id="user"
                name="user"
                placeholder="Enter your username or email"
                autoComplete="username"
                required
                className="w-full px-3 py-2 rounded-xl border-2 border-blue-400 bg-white text-blue-900 placeholder-gray-500 focus:outline-none focus:border-blue-500 focus:ring-2 focus:ring-blue-300 transition"
              />
            </div>

            <div>
              <label
                htmlFor="password"
                className="text-blue-900 font-semibold mb-1 text-base"
              >
                Password
              </label>
              <input
                type="password"
                id="password"
                name="password"
                placeholder="Enter your password"
                autoComplete="current-password"
                required
                className="w-full px-3 py-2 rounded-xl border-2 border-blue-400 bg-white text-blue-900 placeholder-gray-500 focus:outline-none focus:border-blue-500 focus:ring-2 focus:ring-blue-300 transition"
              />
            </div>

            <div className="flex items-center mb-3">
              <input
                type="checkbox"
                id="remember"
                name="remember"
                className="w-5 h-5 rounded accent-blue-500 cursor-pointer"
              />
              <label
                htmlFor="remember"
                className="ml-3 text-blue-700 text-base select-none cursor-pointer"
              >
                Remember me
              </label>
            </div>

            <button
              type="submit"
              className="w-full bg-blue-600 text-white rounded-xl py-3 font-bold tracking-widest uppercase shadow-lg hover:bg-blue-500 active:bg-blue-700 transition"
            >
              Login
            </button>
          </form>

          <div className="mt-5 space-y-2 text-base text-blue-800 text-center">
            <p>
              Forgot your password?{" "}
              <Link to="/forgot-password" className="text-blue-500">
                Reset it
              </Link>
            </p>
            <p>
              Don’t have an account?{" "}
              <Link
                to="/register"
                className="underline text-blue-500 font-semibold"
              >
                Register
              </Link>
            </p>
          </div>
        </div>
      </main>
    </>
  );
}

export default LoginPage;
