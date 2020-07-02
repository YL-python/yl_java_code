var vue = new Vue({
    el: "#app",
    data: {
        user: {id:"",username:"aaa",password:"",age:"",sex:"",email:""},
        userList: []
    },
    methods: {
        findAll: function () {
            var _this = this;  // axios对象和vue对象
            axios.get("/vuejsDemo/user/findAll.do").then(function (response) {
                _this.userList = response.data;
                console.log(_this.userList);
            }).catch(function (err) {
                console.log(err);
            });
        },
        findById: function (userid) {
            var _this = this;
            axios.get("/vuejsDemo/user/findById.do", {
                params: {
                    id: userid
                }
            }).then(function (response) {
              _this.user = response.data;
                $('#myModal').modal("show");
            }).catch(function (err) {
                console.log(err);
            });

        },
        update: function (user) {
            var _this = this;
            axios.post("/vuejsDemo/user/updateUser.do",_this.user).then(function (response) {
                _this.findAll();
            }).catch(function (err) {
                console.log(err);
            });
        }
    },
    // 生命周期 页面加载的时候就查询所有
    created(){
        this.findAll();
    }
});