import Navbar from "../components/NavBar";
import DashboardCard from "../components/DashboardCard";
import { Link } from "react-router-dom";
import IndiaMap from "../components/IndiaMap";
import UserProfilePanel from "../components/UserProfilePanel";

function DashboardPage() {
    return (
        <>
            <Navbar />
            <main className="flex min-h-screen bg-white p-5 space-x-8">

                {/* LEFT PANEL */}
                <UserProfilePanel />

                {/* MAIN PANEL */}
                <section className="flex-1 flex flex-col items-center space-y-10">

                    <div className="flex flex-row flex-nowrap gap-6">
                        <DashboardCard title="Safaris Attended" value="12" icon="🗺️" />
                        <DashboardCard title="Tigers Sighted" value="8" icon="🐅" />
                        <DashboardCard title="Last Safari" value="May 4, 2025" icon="📅" />
                    </div>

                    <div className="w-full flex flex-col items-center space-y-4">
                        <IndiaMap />
                    </div>

                    <Link to="/login" className="underline text-blue-600 font-semibold mt-5">
                        Logout
                    </Link>
                </section>
            </main>
        </>
    );
}

export default DashboardPage;
