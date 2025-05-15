function DashboardCard({ title, value, icon }) {
    return (
        <div className="bg-white rounded-xl shadow-md p-4 flex items-center space-x-3 min-w-[220px]">
            <div className="text-blue-600 text-3xl">
                {icon}
            </div>
            <div>
                <p className="text-2xl font-bold text-blue-700">{value}</p>
                <h3 className="text-base font-medium text-gray-600">{title}</h3>
            </div>
        </div>
    );
}

export default DashboardCard;
