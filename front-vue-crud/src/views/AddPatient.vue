<template>
    <main>
        <Navbar />

        <div class="my-5">
            <div class="mx-auto w-25" style="max-width: 100%;">
                <h2 class="text-center mb-3">Add Patient</h2>
                <form @submit.prevent="addPatient">
                    <!-- Name -->
                    <div class="row">
                        <div class="col-md-12 form-group mb-3">
                           <label for="name" class="form-label">Name</label>
                           <input type="text" name="name" id="name" class="form-control" placeholder="Name" required v-model="patient.name">
                                <p v-if="!nameIsValid" class="text-danger">The name field is required</p>
                        </div>
                    </div>
                    <!-- Email -->
                    <div class="row">
                        <div class="col-md-12 form-group mb-3">
                           <label for="email" class="form-label">Email</label>
                           <input type="email" name="email" id="email" class="form-control" placeholder="Email" required v-model="patient.email"> 
                                 <p  v-if="!emailIsValid" class="text-danger">The email field is not valid</p>         
                        </div>
                    </div>
                    <!-- Phone Number -->
                    <div class="row">
                        <div class="col-md-12 form-group mb-3">
                           <label for="phoneNumber" class="form-label">Phone Number</label>
                           <input type="text" name="phoneNumber" id="phoneNumber" class="form-control" placeholder="Phone Number" required v-model="patient.phoneNumber">
                                 <p v-if="!phoneNumberIsValid" class="text-danger">The phone field is required</p>         
                        </div>
                    </div>
                    <!-- Gender -->
                    <label for="gender" class="form-label">Gender</label>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="gender" id="male" value="male" v-model="patient.gender">
                        <label for="male" class="form-control-label">Male</label>
                    </div>
                     <div class="form-check">
                        <input class="form-check-input" type="radio" name="gender" id="female" value="female" v-model="patient.gender">
                        <label for="female" class="form-control-label">Female</label>
                    </div>
                     <div class="form-check">
                        <input class="form-check-input" type="radio" name="gender" id="others" value="others" v-model="patient.gender">
                        <label for="others" class="form-control-label">Others</label>
                    </div>
                         <p v-if="!genderIsvalid" class="text-danger">The gender field is required</p>         
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

export default {
    name: 'AddPatient',
    components: {
        Navbar
    },
    data() {
        return {
            patient: {
                'name': '',
                'email': '',
                'gender': '',
                'phoneNumber': ''
            }
        }
    },
    

    computed: {
        nameIsValid() {
            return this.patient.name.trim() !== '';   
        },

        emailIsValid() {
            return this.patient.email.trim() !== '';
        },

        phoneNumberIsValid() {
           return this.patient.phoneNumber.trim() !== '';
        },

        genderIsvalid() {
            return !!this.patient.gender;
        }

    },

    methods: {
        async addPatient() {
            // fetch('http://localhost:8080/patients/create', {
            //     method: 'POST',
            //     headers: {
            //         'Content-Type': 'application/json'
            //     },
            //     body: JSON.stringify(this.patient)
            // })
            // .then(data => {
            //     console.log(data)
            //     this.$router.push('/')
            // })
            let loadPatientRequest = false;

            // const formIsValid = this.nameIsValid && this.emailIsValid && this.phoneNumberIsValid && this.genderIsvalid;
            // if (!formIsValid) {
            //     console.log("Form is invalid");
            //     return;
            // }

            try {
                if (loadPatientRequest) {
                    return;
                }
                const response = await fetch('http://localhost:8080/patients/create', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(this.patient)
                });

                if (response?.ok) {
                    loadPatientRequest = true;
                    console.log(response.json)
                    this.$router.push('/')
                } else {
                    // Handle validation
                    // nameIsValid = false;
                }

            } catch (error) {
                console.log("Something went bad: " + error)
            }
        }
    }
}


</script>