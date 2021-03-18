<template>
    <div>
        <h2>{{status.message}}</h2>
    </div>
</template>

<script>
import statusService from '../services/statusService';
export default {
    name: 'status',
    data() {
        return {
            status : {
                apocalypse : false,
                message : 'Not sure, checking to see if we can reach basecamp...'
            }
        }
    },
    created() {
        statusService.getCurrentStatus().then((response) => {
            //TODO handle errors and check for non-200 response codes
            this.status = response.data;
        });
    }
}
</script>

<style scoped>

</style>