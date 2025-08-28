<!-- src/App.vue -->
<template>
  <div>
    <Button variant="destructive" @click="chose">Click me</Button>
  </div>
  <div v-if="ok">
    ni
  </div>

</template>


<script setup lang="ts">
import { ref } from 'vue'
import { Button } from '@/components/ui/button'
const ok = ref(false)
const chose = () =>{
  ok.value = true
}


</script>
