<template>
    <main>
        <Navbar />

        <!-- Table-->
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="text-center">View Patient</h1>
                    <!--Add button -->
                    <a href="/add" class="btn btn-primary">Add Patient</a>
                    <table class="table table-striped">
                        <thead>
                          <tr>
                            <th scope="col">Id</th>
                            <th scope="col">Name</th>
                            <th scope="col">Email</th>
                            <th scope="col">Phone Number</th>
                            <th scope="col">Gender</th>
                            <th scope="col">Action</th>
                          </tr>
                        </thead>
                        <tbody>
                          <tr v-for="patient in patients" :key="patient.id">
                            <th scope="row">{{patient.id}}</th>
                            <td>{{patient.name}}</td>
                            <td>{{patient.email}}</td>
                            <td>{{patient.phoneNumber}}</td>
                            <td>{{patient.gender}}</td>
                            <td>
                              <a class="btn btn-primary" :href="`/edit/${patient.id}`">Edit</a>
                              <button class="btn btn-danger mx-2" @click="deletePatient(patient.id)">Delete</button>
                            </td>
                          </tr>
                        </tbody>
                      </table>
                </div>
            </div>
        </div>
        
    </main>
</template>


<script>
import Navbar from '@/components/Navbar.vue';

const baseUrl = 'http://localhost:8080/patients'

export default {
    name: 'ViewPatients',
    components: {
        Navbar
    },
    data() {
        return {
            patients: []
        }
    },

    beforeMount(){
        this.getPatients()
    },

    methods: {
        getPatients() {
            fetch(baseUrl)
            .then(res => res.json())
            .then(data => {
                this.patients = data.sort((a, b) => a.id - b.id)
                console.log(data)
            })
        },

        deletePatient(id) {
            fetch(`${baseUrl}/delete/${id}`, {
                method: 'DELETE'
            })
            .then(data => {
                console.log(data)
                this.getPatients()
            })
        }
    }
}


</script>