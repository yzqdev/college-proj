import { createStore } from "vuex";

const store = createStore({
  state() {
    return {
      token: null,
      user: {},
    };
  },
  getters: {
    token: (state) => {
      return state.token;
    },
    user: (state) => {
      return state.user;
    },
  },
  mutations: {
    setToken(state, payload) {
      state.token = payload;
    },
  },
  actions: {

  },
});
export default store;
