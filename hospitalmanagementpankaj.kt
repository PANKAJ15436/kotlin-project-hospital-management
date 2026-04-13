data class Patient(val id: Int, val name: String, val age: Int, val disease: String)

data class Doctor(val id: Int, val name: String, val specialization: String)

data class Appointment(val patientName: String, val doctorName: String, val date: String)

val patients = mutableListOf<Patient>()
val doctors = mutableListOf<Doctor>()
val appointments = mutableListOf<Appointment>()

fun main() {

    // Pre-added doctors
    doctors.add(Doctor(1, "Dr. Sharma", "Cardiologist"))
    doctors.add(Doctor(2, "Dr. Khan", "Dermatologist"))

    while (true) {
        println("\n===== HOSPITAL MANAGEMENT SYSTEM =====")
        println("1. Add Patient")
        println("2. View Patients")
        println("3. View Doctors")
        println("4. Book Appointment")
        println("5. View Appointments")
        println("6. Exit")

        print("Enter choice: ")
        when (readLine()!!.toInt()) {

            1 -> addPatient()
            2 -> viewPatients()
            3 -> viewDoctors()
            4 -> bookAppointment()
            5 -> viewAppointments()
            6 -> {
                println("Exiting...")
                return
            }

            else -> println("Invalid choice!")
        }
    }
}

// ---------------- FUNCTIONS ----------------

fun addPatient() {
    print("Enter Name: ")
    val name = readLine()!!

    print("Enter Age: ")
    val age = readLine()!!.toInt()

    print("Enter Disease: ")
    val disease = readLine()!!

    val id = patients.size + 1
    patients.add(Patient(id, name, age, disease))

    println("✅ Patient Added Successfully!")
}

fun viewPatients() {
    println("\n--- Patient List ---")
    if (patients.isEmpty()) {
        println("No patients found.")
    } else {
        for (p in patients) {
            println("ID: ${p.id}, Name: ${p.name}, Age: ${p.age}, Disease: ${p.disease}")
        }
    }
}

fun viewDoctors() {
    println("\n--- Doctor List ---")
    for (d in doctors) {
        println("ID: ${d.id}, Name: ${d.name}, Specialization: ${d.specialization}")
    }
}

fun bookAppointment() {
    print("Enter Patient Name: ")
    val patient = readLine()!!

    print("Enter Doctor Name: ")
    val doctor = readLine()!!

    print("Enter Date: ")
    val date = readLine()!!

    appointments.add(Appointment(patient, doctor, date))

    println("✅ Appointment Booked!")
}

fun viewAppointments() {
    println("\n--- Appointment List ---")
    if (appointments.isEmpty()) {
        println("No appointments found.")
    } else {
        for (a in appointments) {
            println("Patient: ${a.patientName}, Doctor: ${a.doctorName}, Date: ${a.date}")
        }
    }
}