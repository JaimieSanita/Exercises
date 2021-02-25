<template>
  <table>
    <thead>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th># Reviews</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="product in $store.state.products" v-bind:key="product.id">
        <td>{{ product.id }}</td>
        <!--use router-link     must v-bind:to to path to route named product-detail         becuase dynamic route, needs params-->
        <td><router-link        v-bind:to="{name:'product-detail',                 params:{id:product.id}}">
         <!--this product name is now a hyperlink & because w/in a v-for all product names have links-->
          {{ product.name }}
          </router-link>
          </td>
        <td>{{ product.reviews.length }}</td>
      </tr>
    </tbody>
  </table>
</template>

<script>
export default {
  name: "products-list"
};
</script>

<style style="scoped">
th,
td {
  text-align: left;
}
td {
  padding-right: 10px;
  vertical-align: top;
}
tr:nth-child(even) {
  background-color: rgb(238, 238, 238);
}
</style>
