<template>
    <tr v-bind:class="{favorited : review.favorited}">
        <td>{{review.title}}</td>
        <td>{{review.reviewer}}</td>
        <td>{{review.review}}</td>
        <td>
            <img
            src="../assets/star.png"
            v-bind:title="review.rating + ' Star Review'"
            class="star"
            v-for="n in review.rating"
            v-bind:key="n"
            width="20px"
            />

        </td>
        <td>
            <input 
                type="checkbox"
                v-bind:checked="review.favorited"
                v-on:change="onFavoriteChange"
            />
        </td>
    </tr>
</template>

<script>
export default {
    name: "review-table-row",
    props: ["review"],
    methods: {
        onFavoriteChange() {
            this.$store.commit('FLIP_FAVORITED', this.review);
        }
    }
}
</script>

<style scoped>
    tr.favorited {
        background-color: lightyellow;
    }
</style>