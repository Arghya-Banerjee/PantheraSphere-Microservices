function Navbar() {
    return (
      <nav className="w-full bg-gradient-to-r from-blue-600 to-blue-500 shadow-lg py-4 px-8 flex items-center justify-between">
        {/* Logo / Title */}
        <div className="flex items-center space-x-3">
          <img
            src="/logo/logo.png"
            alt="PantheraSphere Logo"
            className="h-10 w-10 object-contain"
          />
          <span className="text-2xl font-extrabold text-white tracking-wide">
            PantheraSphere
          </span>
        </div>
  
        {/* Navigation Links */}
        <div className="space-x-6 text-white font-semibold text-lg">
          <a href="#" className="hover:text-blue-200 transition">
            Home
          </a>
          <a href="#" className="hover:text-blue-200 transition">
            Login
          </a>
          <a href="#" className="hover:text-blue-200 transition">
            Register
          </a>
        </div>
      </nav>
    );
}

export default Navbar;
