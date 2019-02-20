import * as React from "react";
import {Layout} from "antd";

const { Content } = Layout;
class HomePage extends React.Component {
    render() {
        return (
            <Content style={{
                margin: '24px 16px', padding: 24, background: '#fff', minHeight: window.innerHeight,
            }}
            >
                HomePage
            </Content>
        );
    }
}
export default HomePage;