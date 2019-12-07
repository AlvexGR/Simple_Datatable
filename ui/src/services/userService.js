class UserService {
  users = []

  async getAll(page) {
    const response = await fetch("http://localhost:1503/simple_datatable/api/users/page/" + page);
    return await response.json();
  }
}

export default UserService
