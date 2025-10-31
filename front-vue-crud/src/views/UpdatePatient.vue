<template>
    <main>
        <Navbar />
         
        <div class="my-5">
            <div class="mx-auto w-25" style="max-width: 100%;">
                 <h2 class="text-center mb-3">Update Patient</h2>
                 <form @submit.prevent="updatePatient">
                    <!-- Name -->
                    <div class="row">
                        <div class="col-md-12 form-group mb-3">
                           <label for="name" class="form-label">Name</label>
                           <input type="text" name="name" id="name" class="form-control" placeholder="Name" required v-model="patient.name">     
                        </div>
                    </div>
                    <!-- Email -->
                    <div class="row">
                        <div class="col-md-12 form-group mb-3">
                           <label for="email" class="form-label">Email</label>
                           <input type="email" name="email" id="email" class="form-control" placeholder="Email" required v-model="patient.email">     
                        </div>
                    </div>
                    <!-- Phone Number -->
                    <div class="row">
                        <div class="col-md-12 form-group mb-3">
                           <label for="phoneNumber" class="form-label">Phone Number</label>
                           <input type="text" name="phoneNumber" id="phoneNumber" class="form-control" placeholder="Phone Number" required v-model="patient.phoneNumber">     
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 form-group">
                            <input type="submit" value="Submit" class="btn btn-primary w-100">
                        </div>
                    </div>
                 </form>   
            </div>
        </div>

    </main>
</template>


<script>
import Navbar from '@/components/Navbar.vue';

const baseUrl = 'http://localhost:8080/patients'

export default {
    name: 'UpdatePatient',
    components: {
        Navbar
    },

    data() {
        return {
            patient: {
                id: '',
                name: '',
                email: '',
                phoneNumber: '',
                gender: ''
            }
        }
    },

    beforeMount(){
        this.getPatient();
    },

    methods: {
        getPatient() {
            fetch(`${baseUrl}/${this.$route.params.id}`)
            .then(res => res.json())
            .then(data => {
                this.patient = data;
                console.log(this.patient);
            })
        },

        updatePatient() {
            fetch(`${baseUrl}/update`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(this.patient)
            })
            .then(data => {
                console.log(data);
                this.$router.push("/")
                
            })    
        } 
    }
}

</script>