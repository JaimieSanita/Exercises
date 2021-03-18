<template>
  <div id="app">
    <nav id="nav">
      <router-link to="/">Home</router-link> |
      <router-link v-bind:to="{name:'About'}">About</router-link>
    </nav>
    <!--Only ever present in App.vue/top level. Only appears a single time -->
    <router-view/>
  </div>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
