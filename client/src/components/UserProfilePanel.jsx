function UserProfilePanel() {
    return (
        <aside className="w-1/4 bg-white shadow-lg rounded-xl p-5 flex flex-col items-center space-y-4">
            <img
                src="/pic/default-profile-pic.jpg"
                alt="User Profile"
                className="rounded-full w-32 h-32 object-cover border-4 border-blue-500"
            />
            <h2 className="text-xl font-bold text-blue-700">John Doe</h2>
            <p className="text-gray-600">Explorer</p>

            {/* Bio */}
            <p className="text-gray-700 text-center px-2">
                Wildlife enthusiast and conservationist. Loves tracking and photographing Bengal tigers across India's majestic national parks.
            </p>

            {/* User stats */}
            <div className="text-center text-blue-800 space-y-2 mt-4">
                <div>
                    <span className="font-bold">Joined:</span> Jan 2023
                </div>
                <div>
                    <span className="font-bold">Total Safaris:</span> 12
                </div>
                <div>
                    <span className="font-bold">First Checklist:</span> Feb 2023
                </div>
                <div>
                    <span className="font-bold">First Park:</span> Jim Corbett National Park
                </div>
            </div>

            {/* Social links */}
            <div className="flex space-x-4 text-blue-600 text-2xl mt-4">
                <a href="https://example.com" target="_blank" rel="noopener noreferrer">
                    🌐
                </a>
                <a href="https://instagram.com" target="_blank" rel="noopener noreferrer">
                    📸
                </a>
                <a href="https://facebook.com" target="_blank" rel="noopener noreferrer">
                    👍
                </a>
                <a href="https://twitter.com" target="_blank" rel="noopener noreferrer">
                    🐦
                </a>
            </div>
        </aside>
    );
}

export default UserProfilePanel;
